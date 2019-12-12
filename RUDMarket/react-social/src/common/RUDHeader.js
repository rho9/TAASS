import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';
import './AppHeader.css';
import './RUDHeader.css';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';

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
                            { this.props.authenticated && this.props.currentUser.role === "ADMIN" ? (
                                <form>
                                    <NavLink className="btn btn-warning" to="/profile">Profile</NavLink>
                                    &nbsp;
                                    <NavLink className="btn btn-warning" to="/gestione">Gestione</NavLink>
                                    &nbsp;
                                    <NavLink className="btn btn-warning" to="/#"><ShoppingCartIcon /></NavLink>
                                    &nbsp;
                                    <a type="button" className="btn btn-warning" onClick={this.props.onLogout}>Logout</a>
                                </form>
                            ) : this.props.authenticated && this.props.currentUser.role === "USER" ? (
                                <form>
                                    <NavLink className="btn btn-warning" to="/profile">Profile</NavLink>
                                    &nbsp;
                                    <NavLink className="btn btn-warning" to="/#"><ShoppingCartIcon /></NavLink>
                                    &nbsp;
                                    <a type="button" className="btn btn-warning" onClick={this.props.onLogout}>Logout</a>
                                </form>
                            ) : (
                                <form>
                                    <NavLink className="btn btn-warning" to="/login">MyRUD</NavLink>
                                    &nbsp;
                                    <NavLink className="btn btn-warning" to="/signup">Registrazione</NavLink>
                                    {/* &nbsp;
                                    <NavLink to="/signup"><ShoppingCartIcon style={{color: '#ffc107'}} /></NavLink>*/}
                                    &nbsp;
                                    <NavLink className="btn btn-warning" to="/#"><ShoppingCartIcon /></NavLink>
                                </form>
                            )}
                        </form>
                    </div>
                </nav>
            </header>
        );
    }
}

export default RUDHeader;