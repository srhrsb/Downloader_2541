module com.brh.downloader_2541 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.jsoup;

    opens com.brh.downloader_2541 to javafx.fxml;
    exports com.brh.downloader_2541;
}