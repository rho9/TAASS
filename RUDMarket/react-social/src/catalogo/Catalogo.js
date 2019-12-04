import React, { Component } from 'react';
import './Catalogo.css'

import SezioniList from "./SezioniList";

class Catalogo extends Component {
    constructor(props) {
        super(props);
        this.state = {
            sezioni: []
        }
    }

    componentDidMount() {
        fetch('http://localhost:8080/sezione/getSezioni')
            .then(res => res.json())
            .then((data) => {
                this.setState({ sezioni: data })
            })
    }

    render() {
        return (
            <main role="main">
                <section class="jumbotron text-center">
                    <div className="container">
                        <h1 className="jumbotron-heading">Catalogo</h1>
                        <p className="lead text-muted">Sfoglia il catalogo alla ricerca di deliziosi prodotti!</p>
                    </div>
                </section>

                <div className="album py-5 bg-light">
                    <div className="container">
                        <SezioniList sezioni={this.state.sezioni} />
                    </div>
                </div>
            </main>
        );
    }
}

export default Catalogo;