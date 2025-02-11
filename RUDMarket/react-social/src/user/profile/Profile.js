import React, { Component } from 'react';
import './Profile.css';
import {NavLink} from "react-router-dom";

class Profile extends Component {
    constructor(props) {
        super(props);
        console.log(props);
    }
    render() {
        return (
            <div className="profile-container">
                <div className="container">
                    <div className="profile-info">
                        <div className="profile-avatar">
                            { 
                                this.props.currentUser.imageUrl ? (
                                    <img src={this.props.currentUser.imageUrl} alt={this.props.currentUser.name}/>
                                ) : (
                                    <div className="text-avatar">
                                        <span>{this.props.currentUser.name && this.props.currentUser.name[0]}</span>
                                    </div>
                                )
                            }
                        </div>
                        <div className="profile-name">
                           <h2>{this.props.currentUser.name}</h2>
                           <p className="profile-email">{this.props.currentUser.email}</p>
                        </div>
                    </div>
                </div>
                <div className="container">
                    <div className="row">
                        <div className="col-md-4">
                            <h2>Visualizza Sconti</h2>
                            <p>Visualizza gli sconti a te dedicati !</p>
                            <p><NavLink className="btn btn-warning" to="/sconti">Vai &raquo;</NavLink></p>
                        </div>
                        <div className="col-md-4">
                            <h2>Visualizza Ordini</h2>
                            <p>Visualizza gli ordini da te effettuati !</p>
                            <p><NavLink className="btn btn-warning" to="/ordini">Vai &raquo;</NavLink></p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Profile