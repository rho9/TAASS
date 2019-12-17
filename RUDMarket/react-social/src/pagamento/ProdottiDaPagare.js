import React from 'react'
import './Pagamento.css'

const ProdottiDaPagare = ({ prodottiDaPagare }) => {
    return(
        <tbody>
        {prodottiDaPagare.map((prodottoDaPagare) => (
            <li className="list-group-item d-flex justify-content-between lh-condensed">
            <div>
                {
                    prodottoDaPagare.percSconto == 0 ? (
                        <h6 className="my-0">
                            {prodottoDaPagare.prodotto.nome} (x{prodottoDaPagare.quantita})
                        </h6>
                    ) : (
                        <h6 className="my-0">
                            {prodottoDaPagare.prodotto.nome} (x{prodottoDaPagare.quantita}) (-{prodottoDaPagare.percSconto}%)
                        </h6>
                    )
                }
            <small className="text-muted">{prodottoDaPagare.prodotto.marca}</small>
            </div>
            <span className="text-muted">{(prodottoDaPagare.prodotto.prezzo - ((prodottoDaPagare.prodotto.prezzo * prodottoDaPagare.percSconto) / 100)) * prodottoDaPagare.quantita}€</span>
            </li>
        ))}
        </tbody>
    );
};

export default ProdottiDaPagare