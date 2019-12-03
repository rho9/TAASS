import React, { Component } from 'react';
import { Link, NavLink } from 'react-router-dom';
import './AppHeader.css';
import './RUDHeader.css'

class RUDHeader extends Component {
    render() {
        return (
            <header className="app-header">
                <div className="container">
                    <div className="row">
                        <div className="col">
                            <div className="app-branding">
                                <Link to="/" className="app-title">RUD Market</Link>
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
                                                <NavLink to="/prodotto/add">Prodotto</NavLink>
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
        )
    }
}

export default RUDHeader;