import React from 'react'
import './Catalogo.css'
import {Link} from "react-router-dom";
import {getProdottoImage} from "../util/APIUtils";

function foo(idProdotto) {
    getProdottoImage(3)
        .then((data) => {
            alert(data)
            return (
                <img src={{uri: `data:image/gif;base64,${data}`}} />
            )
        })
}

const ProdottoList = ({ prodotti }) => {
    return(
        <div className="row">
            {prodotti.map((prodotto) => (
                <div className="card mb-4 box-shadow">
                    <div className="card-header">
                        <h4 className="my-0 font-weight-normal">{prodotto.nome}</h4>
                    </div>
                    <div className="card-body">
                        <h1 className="card-title pricing-card-title">€{prodotto.prezzo} {
                            prodotto.atKg ? (
                                <small className="text-muted">/ kg</small>
                            ) : (
                                <small className="text-muted"></small>
                            )
                        }</h1>
                        <ul className="list-unstyled mt-3 mb-4">
                            <li>{prodotto.marca}</li>
                        </ul>
                        {
                            foo(prodotto.id)
                        }
                        <Link className="btn btn-warning" to={
                            {
                                pathname: "/addCarrello",
                                idProdotto: prodotto.id,
                                nomeProdotto: prodotto.nome
                            }
                        }>Aggiungi al Carrello</Link>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default ProdottoList