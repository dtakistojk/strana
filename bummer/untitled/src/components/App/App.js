import React from 'react';
import {Route, BrowserRouter as Router, Switch} from 'react-router-dom';
import './App.css';
import {Provider} from "react-redux";
import store from "../../store";
import Home from "../Home/Home";

function App() {
  return (
      <Provider store={store}>
        <Router>
          <Switch>
            <Route path='/home' exact={true} component={Home}/>
          </Switch>
        </Router>
      </Provider>
  );
}

export default App;
