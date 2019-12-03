import React, { Component } from 'react';
import './Signup.css';
import { Link, Redirect } from 'react-router-dom'
import { GOOGLE_AUTH_URL, FACEBOOK_AUTH_URL, GITHUB_AUTH_URL } from '../../constants';
import { signup } from '../../util/APIUtils';
import fbLogo from '../../img/fb-logo.png';
import googleLogo from '../../img/google-logo.png';
import githubLogo from '../../img/github-logo.png';
import Alert from 'react-s-alert';

class Signup extends Component {
    render() {
        if(this.props.authenticated) {
            return <Redirect
                to={{
                pathname: "/",
                state: { from: this.props.location }
            }}/>;            
        }

        return (
            <div className="signup-container">
                <div className="signup-content">
                    <h1 className="signup-title">Registrazione a RUDMarket</h1>
                    <SocialSignup />
                    <div className="or-separator">
                        <span className="or-text">Oppure</span>
                    </div>
                    <SignupForm {...this.props} />
                    <span className="login-link">Hai già un account? <Link to="/login">Login!</Link></span>
                </div>
            </div>
        );
    }
}


class SocialSignup extends Component {
    render() {
        return (
            <div className="social-signup">
                <a className="btn btn-block social-btn google" href={GOOGLE_AUTH_URL}>
                    <img src={googleLogo} alt="Google" /> Registrazione con Google</a>
                <a className="btn btn-block social-btn facebook" href={FACEBOOK_AUTH_URL}>
                    <img src={fbLogo} alt="Facebook" /> Registrazione con Facebook</a>
                <a className="btn btn-block social-btn github" href={GITHUB_AUTH_URL}>
                    <img src={githubLogo} alt="Github" /> Registrazione con Github</a>
            </div>
        );
    }
}

class SignupForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
            email: '',
            password: ''
        };
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const inputName = target.name;
        const inputSurname = target.surname; //TODO Remove if not used
        const inputValue = target.value;

        this.setState({
            [inputName] : inputValue
        });        
    }

    handleSubmit(event) {
        event.preventDefault();   

        const signUpRequest = Object.assign({}, this.state);

        signup(signUpRequest)
        .then(response => {
            Alert.success("You're successfully registered. Please login to continue!");
            this.props.history.push("/login");
        }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
        });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-item">
                    <input type="text" name="name" 
                        className="form-control" placeholder="Nome"
                        value={this.state.name} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <input type="text" name="surname"
                           className="form-control" placeholder="Cognome"
                           value={this.state.surname} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <input type="email" name="email" 
                        className="form-control" placeholder="Email"
                        value={this.state.email} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <input type="password" name="password" 
                        className="form-control" placeholder="Password"
                        value={this.state.password} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <button type="submit" className="btn btn-block btn-primary" >Registrati</button>
                </div>
            </form>                    

        );
    }
}

export default Signup