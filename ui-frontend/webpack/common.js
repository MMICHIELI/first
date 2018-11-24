const { resolve } = require('path');
const HappyPack = require('happypack');
const HtmlWebPackPlugin = require('html-webpack-plugin');
const ForkTsChecker = require('fork-ts-checker-webpack-plugin');
const WebpackPwaManifest = require('webpack-pwa-manifest');

/*
 * babel-loader wrapped into Happypack
 */
const babelPack = new HappyPack({
    id: 'babel',
    threads: 2,
    verbose: false,
    loaders: [{
      path: 'babel-loader',
      query: {
        preset: [
          'env',
          'react',
          'stage_0'
        ],
        plugins: ['transform-object-rest-spread']
      }
    }]
  });

/*
 * ts-loader wrapped into Happypack
 */
const tsPack = new HappyPack({
    id: 'awesome',
    threads: 2,
    verbose: false,
    loaders: [{
      path: 'ts-loader',
      query: {
        happyPackMode: true,
        configFile: resolve(__dirname, '../tsconfig.json')
      }
    }]
  });

/*
 * ForkTsChecker
 */
const forkTsChecker = new ForkTsChecker({
    async: false,
    checkSyntacticErrors: true,
    tsconfig: resolve(__dirname, '../tsconfig.json'),
    tslint: resolve(__dirname, '../tslint.json')
  });

/*
 * Html Web Pack => Entry Point (html)
 */
const htmlPlugin = new HtmlWebPackPlugin({
    title: 'First App',
    template: "index.html",
    filename: "index.html",
    favicon: "./favicon.ico"
  }); 

  const webpackPwaManifest = new WebpackPwaManifest({
    name: 'First App',
    short_name: 'FA',
    description: 'Front-End UI used to develop the render of First microservices.',
    theme_color: '#000000',
    background_color: '#FFFFFF',
    icons: [
      {
        'src': resolve('src/favicon.ico'),
        'size': '16*16',
        'type': 'image/x-icon'
      }
    ],
    display: 'standalone',
    start_url: '.',
    fingerprint: false
  });
  
  module.exports = {
    resolve: {
      extensions: ['*','.ts', '.tsx', '.js', '.jsx', '.json']
    },
    context: resolve(__dirname, '../src'),
    module: {
      rules: [
        // All files with a '.js' or '.jsx' extension
        {
          test: /\.(js|jsx)$/,
          include: /src/,
          exclude: /node_modules/,
          use: [{
            loader: 'cache-loader'
          }, {
            loader: 'happypack/loader?id=babel'
          }]
        },
        { // All files with a '.ts' or '.tsx' extension
          test: /\.(ts|tsx)$/,
          exclude: /node_modules/,
          use: [{
            loader: 'cache-loader'
          }, {
            loader: 'happypack/loader?id=awesome'
          }]
        },
        /*
         * All output '.js' files will have any sourcemaps re-processed
         * by 'babel-loader' & 'eslint-loader'
         */
        {
          enforce: 'pre', test: /\.js$/,
          use: [{
            loader: 'babel-loader'
          }, {
            loader: 'eslint-loader'
          }]
        },
  
        { // All fonts
          test: /\.(eot|ttf|woff|woff2)$/,
          loader: 'file-loader?name=assets/fonts/[name].[ext]'
        },
        {
         // All images
          test: /\.(jpe?g|png|gif|svg)$/,
          loader: 'file-loader?name=assets/images/[name].[ext]'
        }
      ]
    },
  
    optimization: {
      splitChunks: {
        name: true,
        cacheGroups: {
          commons: {
            chunks: 'initial',
            minChunks: 2
          },
          vendor: {
            test: /[\\/]node_modules[\\/]/,
            chunks: 'all',
            priority: -10
          }
        }
      },
      runtimeChunk: true
    },
    plugins: [
      babelPack,
      tsPack,
      forkTsChecker,
      htmlPlugin,
      webpackPwaManifest
    ],
    performance:{
      hints: false
    }
  };