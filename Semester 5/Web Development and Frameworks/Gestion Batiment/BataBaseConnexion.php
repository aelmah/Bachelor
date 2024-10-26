<?php

class BataBaseConnexion
{


    private $DBHost = "localhost";
    private $DBUser = "root";
    private $DBPassword = "1234";
    private $DBName = "myappdb";
    private $connection;

    public function __construct()
    {
        $this->connection = new mysqli($this->DBHost, $this->DBUser, $this->DBPassword, $this->DBName);
        if ($this->connection->connect_error) {
            die('Connection failed: ' . $this->connection->connect_error);
        }
    }

    public function getConnection()
    {
        return $this->connection;
    }

    public function query($sql)
    {
        return $this->connection->query($sql);
    }

    public function closeConnection()
    {
        if ($this->connection) {
            $this->connection->close();
        }
    }


}