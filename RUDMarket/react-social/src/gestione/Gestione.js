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
                            <p><NavLink className="btn btn-warning" to="/addProdotto">Vai &raquo;</NavLink></p>
                        </div>
                        <div className="col-md-4">
                            <h2>Aggiungi Sconti</h2>
                            <p><NavLink className="btn btn-warning" to="/addSconto">Vai &raquo;</NavLink></p>
                        </div>
                        <div className="col-md-4">
                            <h2>Rimuovi Sconti</h2>
                            <p><NavLink className="btn btn-warning" to="/removeSconto">Vai &raquo;</NavLink></p>
                        </div>
                        <div className="col-md-4">
                            <h2>Aggiungi Supermercato</h2>
                            <p><NavLink className="btn btn-warning" to="/addSupemercato">Vai &raquo;</NavLink></p>
                        </div>
                    </div>
                </div>
            </main>
        )
    }
}

export default Home;