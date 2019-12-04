import React from 'react'
import {NavLink} from "react-router-dom";
import Sezione from "./Sezione";

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
                                    <NavLink className="btn btn-warning" to={
                                        {
                                            pathname: "/sezione",
                                            sezioneProps: {
                                                nomeSezione: sezione.nome
                                            }
                                        }
                                    }>Visualizza</NavLink>
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