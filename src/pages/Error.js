import React from 'react';
import { Link } from 'react-router-dom';

const Error = () => {
    return (
        <div>
            <h1> Error ruta no encontrada</h1>
            <Link to="/"><button>Volver a inicio</button></Link>
        </div>
    );
}

export default Error;
