import React, { Component } from 'react';
import './Home.css';
import {NavLink} from "react-router-dom";

class Home extends Component {
    render() {
        return (
            <main role="main">
                <div className="jumbotron">
                    <div className="container">
                        <h1 className="display-3">Benvenuto in RUDMarket!</h1>
                        <p>Una vasta scelta di prodotti ti aspetta!</p>
                        <p><a className="btn btn-warning btn-lg" href="/catalogo" role="button">Sfoglia il catalogo &raquo;</a>
                        </p>
                    </div>
                </div>

                <div className="container">
                    <div className="row">
                        <div className="col-md-4">
                            <h2>Il Tuo account RUDMarket</h2>
                            <p>Scopri gli sconti a te dedicati accedendo all'area personale di RUDMarket. Offerte per te
                                ogni
                                giorno!</p>
                            <p><NavLink className="btn btn-warning" to="/profile">Accedi a MyRUD &raquo;</NavLink></p>
                        </div>
                        <div className="col-md-4">
                            <h2>Dove trovarci</h2>
                            <p>Siamo sparsi in tutto il mondo con tanti punti vendita !</p>
                            <p><a className="btn btn-warning" href="#" role="button">Scopri dove &raquo;</a></p>
                        </div>
                        <div className="col-md-4">
                            <h2>Eventi</h2>
                            <p>Scopri gli eventi nei punti vendita di RUDMarket, potresti trovare il prodotto giusto per
                                te!</p>
                            <p><a className="btn btn-warning" href="#" role="button">Visualizza gli eventi &raquo;</a>
                            </p>
                        </div>
                    </div>

                </div>
            </main>
        )
    }
}

export default Home;