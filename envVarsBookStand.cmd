@echo off

:: Remover esta sección informativa
echo:
echo 1. Remueva los @REM al principio de cada sentencia antes de llegar a PAUSE
echo 2. Edite el archivo para establecer los valores personalizados de las env var (sentencias "set", no "setx")
echo 3. Guarde y vuelva a ejecutar
echo:

:: Credenciales MySQL
@REM set "ENCRYPTED_MYSQL_USERNAME=usuarioEncriptadoDeSuInstanciaMySQL"
@REM setx ENCRYPTED_MYSQL_USERNAME "%ENCRYPTED_MYSQL_USERNAME%"
@REM echo VARIABLE ENCRYPTED_MYSQL_USERNAME: %ENCRYPTED_MYSQL_USERNAME%
@REM echo:

@REM set "ENCRYPTED_MYSQL_PASSWORD=contraseñaEncriptadaDeSuInstanciaMySQL"
@REM setx ENCRYPTED_MYSQL_PASSWORD "%ENCRYPTED_MYSQL_PASSWORD%"
@REM echo VARIABLE ENCRYPTED_MYSQL_PASSWORD: %ENCRYPTED_MYSQL_PASSWORD%
@REM echo:

:: JWT Secret (llave para encriptar)
@REM set "ENCRYPTED_JWT_SECRET=llaveAleatoriaEncriptadaDefinidaPorUsted"
@REM setx ENCRYPTED_JWT_SECRET "%ENCRYPTED_JWT_SECRET%"
@REM echo VARIABLE ENCRYPTED_JWT_SECRET: %ENCRYPTED_JWT_SECRET%
@REM echo:

:: Jasypt password (llave para encriptar datos sensibles/secrets)
@REM set "JASYPT_ENCRYPTOR_PASSWORD=llaveAleatoriaDefinidaPorUsted2"
@REM setx JASYPT_ENCRYPTOR_PASSWORD "%JASYPT_ENCRYPTOR_PASSWORD%"
@REM echo VARIABLE JASYPT_ENCRYPTOR_PASSWORD: %JASYPT_ENCRYPTOR_PASSWORD%
@REM echo:

:: Nota: Las llaves para JWT y Jasypt son diferentes, salvo que la primera se coloca encriptada en este archivo

PAUSE

@REM *** Archivo creado por Diego Mtz Diciembre 30, 2022 ***