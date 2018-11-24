// React
import * as React from 'react';
import { Provider } from 'react-redux';
import { MemoryRouter as Router, Route, Switch } from 'react-router-dom';
import * as lod from 'lodash';

// App Redux
import { ApplicationProps } from './app-redux/types';
import routes from './app-redux/routes';
import store from './app-redux/store';

/**
 * App Root Component
 */
export default class App extends React.Component<ApplicationProps> {
    public render() {
        // tslint:disable no-unsafe-any
        const containers = lod.map(routes, ({ path, component }, key) => (
            // tslint:enable no-unsafe-any
            <Route exact={true} path={path} component={component} key={key} />)
      );

        return (
          <Provider store={store}>
            <div>
              <Router>
                  <Switch>{containers}</Switch>
              </Router>
            </div>
          </Provider>);
    }
}