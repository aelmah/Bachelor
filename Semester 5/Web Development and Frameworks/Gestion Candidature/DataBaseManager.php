<?php

class DatabaseManager
{
    private $host;
    private $username;
    private $password;
    private $database;

    public function __construct($host, $username, $password, $database)
    {
        $this->host = $host;
        $this->username = $username;
        $this->password = $password;
        $this->database = $database;
    }

    // établir une connexion à la base de données
    public function getConnection()
    {
        $conn = new mysqli($this->host, $this->username, $this->password, $this->database);

        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }

        return $conn;
    }

    //  exécuter une requête SQL
    public function executeQuery($query)
    {
        $conn = $this->getConnection();
        $result = $conn->query($query);
        $conn->close();
        return $result;
    }


}