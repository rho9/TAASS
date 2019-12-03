import React from 'react'

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
                                    <button type="button"
                                            className="btn btn-sm btn-warning">Visualizza
                                    </button>
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