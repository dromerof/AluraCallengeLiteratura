package com.alura.callenge.literatura.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}