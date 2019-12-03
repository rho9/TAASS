import React, { Component } from 'react';
import { Link, NavLink } from 'react-router-dom';
import './AppHeader.css';
import './RUDHeader.css'

class RUDHeader extends Component {
    render() {
        return (
            <header className="app-header">
                <div className="container">
                    <div className="app-branding">
                        <Link to="/" className="app-title">RUD Market</Link>
                    </div>
                    <div className="app-options">
                        <nav className="app-nav">
                                { this.props.authenticated && this.props.currentUser.role == "ADMIN" ? (
                                    <ul>
                                        <li>
                                            <NavLink to="/profile">Profile</NavLink>
                                        </li>
                                        <li>
                                            <NavLink to="/prodotto/add">Prodotto</NavLink>
                                        </li>
                                        <li>
                                            <NavLink to="/sezione/add">Sezione</NavLink>
                                        </li>
                                        <li>
                                            <a onClick={this.props.onLogout}>Logout</a>
                                        </li>
                                    </ul>
                                ): this.props.authenticated && this.props.currentUser.role == "USER" ? (
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
                                            <NavLink to="/login">Login</NavLink>
                                        </li>
                                        <li>
                                            <NavLink to="/signup">Signup</NavLink>
                                        </li>
                                    </ul>
                                )}
                        </nav>
                    </div>
                    <div className="row">
                        <div className="col">
                            <div className="btn-group-nav">
                                <button className="button">Home</button>
                                <button className="button">Catalogo</button>
                                <button className="button">Promozioni</button>
                                <button className="button">Dove Siamo</button>
                                <button className="button">Contattaci</button>
                            </div>
                        </div>
                        <div className="col-6">
                            <article>
                                <h1>Eventi</h1>
                            </article>
                        </div>
                        <div className="col">
                        </div>
                    </div>
                </div>
            </header>
        )
    }
}

export default RUDHeader;