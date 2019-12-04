import React, { Component } from 'react';
import { Link, NavLink } from 'react-router-dom';
import './AppHeader.css';
import './RUDHeader.css'

class RUDHeader extends Component {
    render() {

        return(
            <header>
                <nav className="navbar navbar-expand-lg fixed-top navbar-custom">
                    <a className="navbar-brand" href="/">RUDMarket</a>
                    <div className="collapse navbar-collapse" id="navbarCollapse">
                        <ul className="navbar-nav mr-auto">
                        </ul>
                        <form className="form-inline mt-2 mt-md-0">
                            { this.props.authenticated ? (
                                <form>
                                    <NavLink className="btn btn-warning" to="/profile">Profile</NavLink>
                                    <a type="button" className="btn btn-warning" onClick={this.props.onLogout}>Logout</a>
                                </form>
                            ) : (
                                <form>
                                    <NavLink className="btn btn-warning" to="/login">MyRUD</NavLink>
                                    <NavLink className="btn btn-warning" to="/signup">Registrazione</NavLink>
                                </form>
                            )}
                        </form>
                    </div>
                </nav>
            </header>
        );

        /*return (
            <header className="app-header">
                <div className="container">
                    <div className="row">
                        <div className="col">
                            <div className="app-branding">
                                <Link to="/" className="app-title">RUDMarket</Link>
                            </div>
                        </div>
                        <div className="col">

                        </div>
                        <div className="col">
                            <div className="app-options">
                                <nav className="app-nav">
                                    { this.props.authenticated && this.props.currentUser.role === "ADMIN" ? (
                                        <ul>
                                            <li>
                                                <NavLink to="/profile">Profile</NavLink>
                                            </li>
                                            <li>
                                                <NavLink to="/prodotto/add">Sezione</NavLink>
                                            </li>
                                            <li>
                                                <NavLink to="/sezione/add">Sezione</NavLink>
                                            </li>
                                            <li>
                                                <a onClick={this.props.onLogout}>Logout</a>
                                            </li>
                                        </ul>
                                    ): this.props.authenticated && this.props.currentUser.role === "USER" ? (
                                        <ul>
                                            <li>
                                                <NavLink to="/profile">Profile</NavLink>
                                            </li>
                                            <li>
                                                <a onClick={this.props.onLogout}>Logout</a>
                                            </li>
                                        </ul>
                                    ) : (
                                        <ul>
                                            <li>
                                                <NavLink to="/login">MyRUD</NavLink>
                                            </li>
                                            <li>
                                                <NavLink to="/signup">Registrazione</NavLink>
                                            </li>
                                        </ul>
                                    )}
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
        )*/
    }
}

export default RUDHeader;