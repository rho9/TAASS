import React from 'react'
import './Catalogo.css'

const ProdottoList = ({ prodotti }) => {
    return(
        <div className="row">
            {prodotti.map((prodotto) => (
                <div className="card mb-4 box-shadow">
                    <div className="card-header">
                        <h4 className="my-0 font-weight-normal">{prodotto.nome}</h4>
                    </div>
                    <div className="card-body">
                        <h1 className="card-title pricing-card-title">€{prodotto.prezzo} <small className="text-muted">/ kg</small></h1>
                        <ul className="list-unstyled mt-3 mb-4">
                            <li>{prodotto.marca}</li>
                        </ul>
                        <button type="button" className="btn btn-warning">Aggiungi al Carrello
                        </button>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default ProdottoList