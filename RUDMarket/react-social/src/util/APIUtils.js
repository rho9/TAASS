import { API_BASE_URL, ACCESS_TOKEN } from '../constants';

const request = (options) => {
    const headers = new Headers({
        'Content-Type': 'application/json',
    })
    
    if(localStorage.getItem(ACCESS_TOKEN)) {
        headers.append('Authorization', 'Bearer ' + localStorage.getItem(ACCESS_TOKEN))
    }

    const defaults = {headers: headers};
    options = Object.assign({}, defaults, options);

    return fetch(options.url, options)
    .then(response => 
        response.json().then(json => {
            if(!response.ok) {
                return Promise.reject(json);
            }
            return json;
        })
    );
};

export function getCurrentUser() {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }

    return request({
        url: API_BASE_URL + "/user/me",
        method: 'GET'
    });
}

export function login(loginRequest) {
    return request({
        url: API_BASE_URL + "/auth/login",
        method: 'POST',
        body: JSON.stringify(loginRequest)
    });
}

export function signup(signupRequest) {
    return request({
        url: API_BASE_URL + "/auth/signup",
        method: 'POST',
        body: JSON.stringify(signupRequest)
    });
}

export function addProdotto(addProdottoRequest){
    return request({
        url: API_BASE_URL + "/prodotto/addProdotto",
        method: 'POST',
        body: JSON.stringify(addProdottoRequest)
    });
}

export function addSezione(addSezioneRequest){
    return request({
        url: API_BASE_URL + "/sezione/addSezione",
        method: 'POST',
        body: JSON.stringify(addSezioneRequest)
    });
}

export function addProdottoInCarrello(addProdottoInCarrelloRequest){
    return request({
        url: API_BASE_URL + "/carrello/addProdottoInCarrello",
        method: 'POST',
        body: JSON.stringify(addProdottoInCarrelloRequest)
    });
}

export function getProdottiInCarrello(getProdottiInCarrelloRequest){
    return request({
        url: API_BASE_URL + "/carrello/getProdottiInCarrello",
        method: 'GET',
        body: JSON.stringify(getProdottiInCarrelloRequest)
    });
}

export function getCostoTotale(getCostoTotaleRequest){
    return request({
        url: API_BASE_URL + "/carrello/getCostoTotale",
        method: 'GET',
        body: JSON.stringify(getCostoTotaleRequest)
    });
}

export function addSconto(addScontoRequest){
    return request({
        url: API_BASE_URL + "/sconto/addSconto",
        method: 'POST',
        body: JSON.stringify(addScontoRequest)
    });
}

export function findUtenti(findUtentiRequest){
    return request({
        url: API_BASE_URL + "/user/findUtenti",
        method: 'POST',
        body: findUtentiRequest
    });
}

export function getScontiAttivi(getScontiAttiviRequest) {
    return request({
        url: API_BASE_URL + "/sconto/getScontiAttivi",
        method: 'GET',
        body: JSON.stringify(getScontiAttiviRequest)
    });
}

export function getOrdiniAttivi(getOrdiniAttiviRequest) {
    return request({
        url: API_BASE_URL + "/ordine/getOrdiniAttivi",
        method: 'GET',
        body: JSON.stringify(getOrdiniAttiviRequest)
    });
}

export function effettuaPagamento(effettuaPagamentoRequest){
    return request({
        url: API_BASE_URL + "/carrello/effettuaPagamento",
        method: 'POST',
        body: JSON.stringify(effettuaPagamentoRequest)
    });
}

export function findScontiByUtente(emailUtente){
    return request({
        url: API_BASE_URL + "/sconto/findScontiByUtente",
        method: 'POST',
        body: emailUtente
    });
}

export function removeSconto(scontoId){
    return request({
        url: API_BASE_URL + "/sconto/removeSconto",
        method: 'POST',
        body: scontoId
    });
}

export function getSupermercati(getSupermercatiRequest){
    return request({
        url: API_BASE_URL + "/sup/getSupermercati",
        method: 'POST',
        body: JSON.stringify(getSupermercatiRequest)
    });
}

export function getSezioni(getSezioniRequest){
    return request({
        url: API_BASE_URL + "/sezione/getSezioni",
        method: 'POST',
        body: JSON.stringify(getSezioniRequest)
    });
}

export function addSupermercato(addSupermercatoRequest){
    return request({
        url: API_BASE_URL + "/sup/addSupermercato",
        method: 'POST',
        body: JSON.stringify(addSupermercatoRequest)
    });
}

export function addOrdine(addOrdineRequest){
    return request({
        url: API_BASE_URL + "/ordine/addOrdine",
        method: 'POST',
        body: JSON.stringify(addOrdineRequest)
    });
}