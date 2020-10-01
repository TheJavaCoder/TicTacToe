module com.tictactoe_server {
    requires javafx.controls;
    requires java.sql;
    exports com.tictactoe_server;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
}
