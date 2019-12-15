import React, { Component } from 'react';
import {
  Route,
  Switch
} from 'react-router-dom';
import RUDHeader from '../common/RUDHeader';
import Home from '../home/Home';
import Login from '../user/login/Login';
import Signup from '../user/signup/Signup';
import Profile from '../user/profile/Profile';
import OAuth2RedirectHandler from '../user/oauth2/OAuth2RedirectHandler';
import NotFound from '../common/NotFound';
import LoadingIndicator from '../common/LoadingIndicator';
import { getCurrentUser } from '../util/APIUtils';
import { ACCESS_TOKEN } from '../constants';
import PrivateRoute from '../common/PrivateRoute';
import 'react-s-alert/dist/s-alert-default.css';
import 'react-s-alert/dist/s-alert-css-effects/slide.css';
import './App.css';
import '../home/jumbotron.css';
import 'bootstrap/dist/css/bootstrap.css';
import AddSezione from "../gestione/AddSezione";
import AddProdotto from "../gestione/AddProdotto";
import Catalogo from "../catalogo/Catalogo";
import Sezione from "../catalogo/Sezione";
import Gestione from "../gestione/Gestione";
import AdminRoute from "../common/AdminRoute";
import Carrello from "../carrello/Carrello";
import AddProdottoAlCarrello from "../carrello/AddProdottoAlCarrello";
import AddSconto from "../gestione/AddSconto";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      authenticated: false,
      currentUser: null,
      loading: false
    }

    this.loadCurrentlyLoggedInUser = this.loadCurrentlyLoggedInUser.bind(this);
    this.handleLogout = this.handleLogout.bind(this);
  }

  loadCurrentlyLoggedInUser() {
    this.setState({
      loading: true
    });

    getCurrentUser()
    .then(response => {
      this.setState({
        currentUser: response,
        authenticated: true,
        loading: false
      });
    }).catch(error => {
      this.setState({
        loading: false
      });  
    });    
  }

  handleLogout() {
    localStorage.removeItem(ACCESS_TOKEN);
    this.setState({
      authenticated: false,
      currentUser: null
    });
    window.location.href = "/";
  }

  componentDidMount() {
    this.loadCurrentlyLoggedInUser();
  }

  render() {
    if(this.state.loading) {
      return <LoadingIndicator />
    }

    return(
      <body>
        <RUDHeader authenticated={this.state.authenticated} currentUser={this.state.currentUser} onLogout={this.handleLogout} />

        <div className="app-body">
          <Switch>
            <Route exact path="/" component={Home}></Route>
            <Route path="/catalogo" component={Catalogo}></Route>
              <Route path="/sezione" component={Sezione}></Route>
            <PrivateRoute path="/profile" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                          component={Profile}></PrivateRoute>
            <PrivateRoute path="/carrello" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                          component={Carrello}></PrivateRoute>
            <PrivateRoute path="/addCarrello" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                          component={AddProdottoAlCarrello}></PrivateRoute>
            <AdminRoute path="/gestione" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                          component={Gestione}></AdminRoute>
            <AdminRoute path="/addSezione" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                        component={AddSezione}></AdminRoute>
            <AdminRoute path="/addSconto" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                        component={AddSconto}></AdminRoute>
            <AdminRoute path="/addProdotto" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                        component={AddProdotto}></AdminRoute>
            <PrivateRoute path="/sezione/add" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                          component={AddSezione}></PrivateRoute>
            <Route path="/login"
                   render={(props) => <Login authenticated={this.state.authenticated} {...props} />}></Route>
            <Route path="/signup"
                   render={(props) => <Signup authenticated={this.state.authenticated} {...props} />}></Route>
            <Route path="/oauth2/redirect" component={OAuth2RedirectHandler}></Route>
            <Route component={NotFound}></Route>
          </Switch>
        </div>
        <footer className="container">
          <p>&copy; Powered by RUD 2019/2020</p>
        </footer>
      </body>
    );
  }
}

export default App;
