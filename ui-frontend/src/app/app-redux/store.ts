import { combineReducers, Middleware, Reducer, applyMiddleware, Store, createStore } from 'redux';
import { ApplicationState } from './types';
import { composeWithDevTools } from 'redux-devtools-extension';

const reducers: Reducer<ApplicationState> = combineReducers<ApplicationState>({
  // TODO
});

// Custom logger
const logger: Middleware = (applicationStore) => (next) => (action) => {
  if (process.env.MODE_ENV !== 'production') {
    // tslint:disable no-console
    console.log('Action dispatched', action);
    // tslint:enable no-console

    const returnValue = next(action);

    // tslint:disable no-console
    console.log('New State', applicationStore.getState());
    // tslint:enable no-console

    return returnValue;
  }

  return next(action);
};

// Middle wares
let middleWare;

if (process.env.MODE_ENV !== 'production') {
  // Need to think on this - doesn't work with redux 4
  middleWare = applyMiddleware(logger);
  middleWare = composeWithDevTools(middleWare);
}

const store: Store<ApplicationState> = createStore(reducers, {}, middleWare);

export default store;