const Merge = require('webpack-merge');
const { resolve } = require('path');
const Webpack = require('webpack');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const UglifyjsWebpackPlugin = require('uglifyjs-webpack-plugin');
const commonConfig = require('./common');

module.exports = Merge(commonConfig, {
  mode: 'production',
  entry: './index.tsx',
  output: {
    filename: '[name].[chunkhash].js',
    path: resolve(__dirname, '../dist'),
    publicPath: `/${process.env.PROJECT}/`
  },
  devtool: 'source-map',
  plugins: [

    new CleanWebpackPlugin(['dist'],
      function() {
        this.plugin('done', function(stats) {
          if (stats && stats.hasErrors()) {
            stats.toJSON().errors.forEach((err) => {
              console.error(err);
            });
            process.exit(1);
          }
        })
      }
    ),

    new UglifyjsWebpackPlugin({
      parallel: true,
      sourceMap: false
    })
  ]
});