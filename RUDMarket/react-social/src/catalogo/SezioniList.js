import React from 'react'
import {Link} from "react-router-dom";

const SezioniList = ({ sezioni }) => {
    return(
        <div className="row">
            {sezioni.map((sezione) => (
                <div className="col-md-4">
                    <div className="card mb-4 box-shadow">
                        <div className="card-body">
                            <p className="card-text">{sezione.nome}</p>
                            <div className="d-flex justify-content-between align-items-center">
                                <div className="btn-group">
                                    <Link className="btn btn-warning" to={
                                        {
                                            pathname: "/sezione",
                                            nomeSezione: sezione.nome,
                                            idSezione: sezione.id,
                                            prodottoList: sezione.prodottoList
                                        }
                                    }>

                                    Visualizza</Link>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default SezioniList