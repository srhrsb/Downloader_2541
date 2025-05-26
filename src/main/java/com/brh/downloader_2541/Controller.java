package com.brh.downloader_2541;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    TextField url;

    @FXML
    TextField target;

//________AUFGABEN_________________________________________________________________________________________
//    a) Sorgen Sie dafür, dass auf Knopfdruck ein Download in den angegebenen Folder durchgeführt wird.
//
//    b) Implementieren Sie, dass der Zielordner via Folder-Dialog angegeben werden kann.
//
//    c) Bauen Sie die Klasse "Download" so um, dass Sie nebenläufig funktioniert.
//
//    d) Stellen Sie fest, ob es sich bei der URL um einen Ordner handelt. Wenn das der Fall ist, soll der
//    gesamte Ordnerinhalt runtergeladen werden, sonst nur die einzelne Datei.
//
//    e) Fügen Sie eine Tabelle hinzu, die die URLs anzeigen soll, die gerade runtergeladen werden. In der
//    ersten Spalte die URL, in der zweiten die bereits geladenen Bytes.
//
//    f) Implementieren Sie, das alle URLs beim Start des Downloads in der Tabelle angezeigt werden und die bereits geladenen Bytes während des Downloads angezeigt werden.
//

    /**
     * Download der in URL gegebenen Datei in den Ordner, der in target gegeben ist
     */
    @FXML
    protected void onDownloadClick() {

    }
}