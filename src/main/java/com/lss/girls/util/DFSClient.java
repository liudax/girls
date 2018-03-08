package com.lss.girls.util;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * @author Magic
 * @date 11:02 2018/2/26
 * @description
 */

public class DFSClient {
    private  static final String CONFIG_FILE_PATH = "/fdfs_client.conf";
    private TrackerServer trackerServer;
    private TrackerClient trackerClient;
    private StorageServer storageServer;
    private StorageClient1 storageClient1;

    public DFSClient() throws IOException, MyException  {
        this(CONFIG_FILE_PATH);
    }
    public DFSClient(String conf) throws IOException, MyException {
        conf = this.getClass().getResource("/").getPath()+conf;
        ClientGlobal.init(conf);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageClient1 = new StorageClient1(trackerServer,null);
    }


    public String  uploadFile(FastFile file) throws IOException, MyException {
        return storageClient1.upload_file1(file.getGroupName(),file.getContent(),file.getExtName(),file.getPairs());
    }
    public byte[] downloadFile(String fileId) throws IOException, MyException {
        return storageClient1.download_file1(fileId);
    }
    public int deleteFile(String fileId) throws IOException, MyException {
        return storageClient1.delete_file1(fileId);
    }
}
