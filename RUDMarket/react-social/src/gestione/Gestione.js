import './Gestione.css'
import {NavLink} from "react-router-dom";
import React, {Component} from "react";

class Home extends Component {
    render() {
        return (
            <main role="main">
                <div className="container">
                    <div className="row">
                        <div className="col-md-4">
                            <h2>Aggiungi Sezione</h2>
                            <p><NavLink className="btn btn-warning" to="/addSezione">Vai &raquo;</NavLink></p>
                        </div>
                        <div className="col-md-4">
                            <h2>Aggiungi Prodotti</h2>
                            <p><NavLink className="btn btn-warning" to="/profile">Vai &raquo;</NavLink></p>
                        </div>
                    </div>

                </div>
            </main>
        )
    }
}

export default Home;