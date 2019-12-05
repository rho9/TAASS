import React from 'react';
import {
    Route,
    Redirect
} from "react-router-dom";


const AdminRoute = ({ component: Component, authenticated, currentUser, ...rest }) => (
    <Route
        {...rest}
        render={props =>
            authenticated && currentUser.role === 'ADMIN' ? (
                <Component {...rest} {...props} />
            ) : (
                <Redirect
                    to={{
                        pathname: '/login',
                        state: { from: props.location }
                    }}
                />
            )
        }
    />
);

export default AdminRoute;