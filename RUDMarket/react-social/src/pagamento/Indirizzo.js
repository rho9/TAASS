import React from "react";

export function personalAddress(){
    return (
        <div>
            <div className="row">
                <div className="col-md-6 mb-3">
                    <label htmlFor="cc-name">Nome</label>
                    <input type="text" className="form-control" required/>
                </div>
                <div className="col-md-6 mb-3">
                    <label htmlFor="cc-name">Cognome</label>
                    <input type="text" className="form-control" required/>
                </div>
            </div>
            <div className="mb-3">
                <label htmlFor="cc-name">Indirizzo</label>
                <input type="text" className="form-control" required/>
                <small className="text-muted">Indicare l'indirizzo per la consegna</small>
            </div>
        </div>
    )
}