import React, { Component } from 'react';
import './Sezione.css';

const Sezione = (pr) => {
    return(
        <body>
        <div className="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
            <h1 className="display-4">{pr.nomeSezione}</h1>
        </div>

        <div className="container">
            <div className="card-deck mb-3 text-center">
                <div className="card mb-4 box-shadow">
                    <div className="card-header">
                        <h4 className="my-0 font-weight-normal">Free</h4>
                    </div>
                    <div className="card-body">
                        <h1 className="card-title pricing-card-title">$0 <small className="text-muted">/
                            mo</small></h1>
                        <ul className="list-unstyled mt-3 mb-4">
                            <li>10 users included</li>
                            <li>2 GB of storage</li>
                            <li>Email support</li>
                            <li>Help center access</li>
                        </ul>
                        <button type="button" className="btn btn-lg btn-block btn-outline-primary">Sign up for
                            free
                        </button>
                    </div>
                </div>
                <div className="card mb-4 box-shadow">
                    <div className="card-header">
                        <h4 className="my-0 font-weight-normal">Pro</h4>
                    </div>
                    <div className="card-body">
                        <h1 className="card-title pricing-card-title">$15 <small className="text-muted">/
                            mo</small></h1>
                        <ul className="list-unstyled mt-3 mb-4">
                            <li>20 users included</li>
                            <li>10 GB of storage</li>
                            <li>Priority email support</li>
                            <li>Help center access</li>
                        </ul>
                        <button type="button" className="btn btn-lg btn-block btn-primary">Get started</button>
                    </div>
                </div>
                <div className="card mb-4 box-shadow">
                    <div className="card-header">
                        <h4 className="my-0 font-weight-normal">Enterprise</h4>
                    </div>
                    <div className="card-body">
                        <h1 className="card-title pricing-card-title">$29 <small className="text-muted">/
                            mo</small></h1>
                        <ul className="list-unstyled mt-3 mb-4">
                            <li>30 users included</li>
                            <li>15 GB of storage</li>
                            <li>Phone and email support</li>
                            <li>Help center access</li>
                        </ul>
                        <button type="button" className="btn btn-lg btn-block btn-primary">Contact us</button>
                    </div>
                </div>
            </div>
        </div>
        </body>
    )
}

/*class Sezione extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return(
            <body>
                <div className="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
                    <h1 className="display-4">{this.props.location.nomeSezione}</h1>
                </div>

                <div className="container">
                    <div className="card-deck mb-3 text-center">
                        <div className="card mb-4 box-shadow">
                            <div className="card-header">
                                <h4 className="my-0 font-weight-normal">Free</h4>
                            </div>
                            <div className="card-body">
                                <h1 className="card-title pricing-card-title">$0 <small className="text-muted">/
                                    mo</small></h1>
                                <ul className="list-unstyled mt-3 mb-4">
                                    <li>10 users included</li>
                                    <li>2 GB of storage</li>
                                    <li>Email support</li>
                                    <li>Help center access</li>
                                </ul>
                                <button type="button" className="btn btn-lg btn-block btn-outline-primary">Sign up for
                                    free
                                </button>
                            </div>
                        </div>
                        <div className="card mb-4 box-shadow">
                            <div className="card-header">
                                <h4 className="my-0 font-weight-normal">Pro</h4>
                            </div>
                            <div className="card-body">
                                <h1 className="card-title pricing-card-title">$15 <small className="text-muted">/
                                    mo</small></h1>
                                <ul className="list-unstyled mt-3 mb-4">
                                    <li>20 users included</li>
                                    <li>10 GB of storage</li>
                                    <li>Priority email support</li>
                                    <li>Help center access</li>
                                </ul>
                                <button type="button" className="btn btn-lg btn-block btn-primary">Get started</button>
                            </div>
                        </div>
                        <div className="card mb-4 box-shadow">
                            <div className="card-header">
                                <h4 className="my-0 font-weight-normal">Enterprise</h4>
                            </div>
                            <div className="card-body">
                                <h1 className="card-title pricing-card-title">$29 <small className="text-muted">/
                                    mo</small></h1>
                                <ul className="list-unstyled mt-3 mb-4">
                                    <li>30 users included</li>
                                    <li>15 GB of storage</li>
                                    <li>Phone and email support</li>
                                    <li>Help center access</li>
                                </ul>
                                <button type="button" className="btn btn-lg btn-block btn-primary">Contact us</button>
                            </div>
                        </div>
                    </div>
                </div>
            </body>
        );
    }
}*/

export default Sezione;