package com.brh.downloader_2541;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {

    @FXML
    private TextField url;

    @FXML
    private TextField target;

    @FXML
    private TableView<DownloadItem> tableView;

    @FXML
    private TableColumn<DownloadItem, String> columnUrls;

    @FXML
    private TableColumn<DownloadItem, Integer> columnBytes;

    private final ObservableList<DownloadItem> downloadItems = FXCollections.observableArrayList();

    /**
     * Initialisierung bei Instanzierung dieses Objekts
     * es wird der Bezug der Spalten des TableView zur Modellklasse
     * DownloadItem hergestellt
     */
    @FXML
    public void initialize() {
        columnUrls.setCellValueFactory(new PropertyValueFactory<DownloadItem,String>("Link"));
        columnBytes.setCellValueFactory(new PropertyValueFactory<DownloadItem,Integer>("DownloadedBytes"));
    }

    /**
     * Download der in URL gegebenen Datei in den Ordner, der in target gegeben ist
     */
    @FXML
    protected void onDownloadClick() {
        String targetFolder = target.getText();

        if(!targetFolder.isEmpty())   {
            int downloadIndex = 0;
            for( var item : downloadItems){
                //nebenläufiger Prozess der Objecte vom Typen "Runable" ausführt
                new Thread( new Download( item.getLink(), targetFolder, downloadIndex, this::updateBytes ) ).start();
                downloadIndex++;
            }
        }
    }
    /**
     * Link wird hinzugefügt zur Liste DownloadItems und an TableView zur Darstellung übergeben
     */
    @FXML
    public void addLink() {

        String link = url.getText();
        if(link.isEmpty()) return;

        var urlList = Directories.getAllFiles(link);

        if(urlList!= null){
            for( var l : urlList){
                downloadItems.add(new DownloadItem(l, 0));
            }
        }

        downloadItems.add(new DownloadItem(link, 0));
        url.setText("");

        tableView.setItems( downloadItems );
    }

    @FXML
    protected void searchFolder() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory( new File(System.getProperty("user.home")) );
        File selected = directoryChooser.showDialog( App.getStage() );

        if(selected != null) {
            target.setText(selected.getAbsolutePath());
        }
    }

    /**
     * Alle Downloads löschen
     */
    @FXML
    protected void clearAllDownloads(){
        downloadItems.clear();
        tableView.setItems( downloadItems );
    }

    /**
     * Download der sich im Focus befindet
     */
    @FXML
    protected void deleteDownload(){
        var focus = tableView.getFocusModel();
        int index = focus.focusedIndexProperty().getValue();
        downloadItems.remove(index);
        tableView.setItems( downloadItems );
    }


    /**
     * Starten der Downloads, welche in der Liste eingetragen sind
     */
    @FXML
    protected void download() {
        String targetFolder = target.getText();

        if (!targetFolder.isEmpty()) {
            int downloadIndex = 0;
            for (var item : downloadItems) {
                //nebenläufiger Prozess der Objecte vom Typen "Runable" ausführt
                new Thread( new Download(item.getLink(), targetFolder, downloadIndex, this::updateBytes) ).start();
                downloadIndex++;
            }
        }
    }

    private void updateBytes( int index, int bytes) {
        var downloadItem = downloadItems.get(index);
        downloadItem.setDownloadedBytes( bytes);
        tableView.setItems( downloadItems );
        tableView.refresh();
    }
}