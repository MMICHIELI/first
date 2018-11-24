import * as React from 'react';
import * as ReactDom from 'react-dom';

import App from './app/App';
import { AppContainer } from 'react-hot-loader';

const render = (Component: React.ComponentClass) => {
    ReactDom.render(
        <AppContainer>
            <Component />
        </AppContainer>,
        document.getElementById('root')
    );
};

render(App);
// tslint:disable-next-line no-any
declare let module: { hot: any };

if (module.hot) {
    module.hot.accept('./app/App', () => {
        render(App);
    });
}