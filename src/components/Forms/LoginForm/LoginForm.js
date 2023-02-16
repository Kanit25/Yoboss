import './LoginForm.css'
import React from 'react';
import { Formik } from 'formik';

const LoginForm = () => {
    return (
        
        <div className='Page'>
        <h1>Login</h1>
            <Formik
                initialValues={{ email: '', password: '', name: '' }}
                validate={values => {
                    const errors = {};

                    if (!values.name) {
                        errors.name = 'Campo obligatorio';
                    }

                    if(!values.password){
                        errors.password = 'Campo obligatorio';
                    }

                    if (!values.email ) {
                        errors.email = 'Campo obligatorio';                     
                    } else if (
                        !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
                    ) {
                        errors.email = 'email invalido';
                    }
                    return errors;
                }}
                onSubmit={(values, { setSubmitting }) => {
                    setTimeout(() => {
                        alert(JSON.stringify(values, null, 2));
                        setSubmitting(false);
                    }, 400);
                }}
            >
                {({
                    values,
                    errors,
                    touched,
                    handleChange,
                    handleBlur,
                    handleSubmit,
                    isSubmitting,
                    /* and other goodies */
                }) => (
                    <form onSubmit={handleSubmit} className='Form'>
                        <input
                            className='Form--input'
                            type="email"
                            name="email"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            value={values.email}
                            placeholder='Ingrese su e-mail'
                        />
                        {errors.email && touched.email && errors.email}
                        <input
                            className='Form--input'
                            type="password"
                            name="password"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            value={values.password}
                            placeholder='Ingrese su contraseña'
                        />
                        {errors.password && touched.password && errors.password}
                        <button className='Form--button' type="submit" disabled={isSubmitting}>
                            Enviar
                        </button>
                    </form>
                )}
            </Formik>
        </div>
    );
}

export default LoginForm;