package com.maxzuo.elastic;

import com.alibaba.fastjson.JSON;
import com.maxzuo.elastic.model.RecordDTO;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;

/**
 * 全文搜索引擎ElasticSearch探索
 * Created by zfh on 2019/01/24
 */
public class ElasticSearchMain {

    private static final Logger    logger     = LoggerFactory.getLogger(ElasticSearchMain.class);

    private static final String    INDEX_NAME = "test_zfh";

    private static final String    TYPE_NAME  = "person";

    private static TransportClient client;

    static {
        Settings settings = Settings.settingsBuilder().put("client.transport.ignore_cluster_name", true)
            .put("client.transport.sniff", true).build();
        try {
            client = TransportClient.builder().settings(settings).build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.3.186"), 9300));
        } catch (Exception e) {
            logger.error("ElasticSearch连接异常 errMessage = {}", e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        /// 1.查询记录
        GetResponse response = getRecordByPrimaryKey(INDEX_NAME, TYPE_NAME, "1");
        if (response.isExists()) {
            System.out.println("response: " + JSON.toJSONString(response));
        }
        /// 2.添加记录
        //Person person = new Person("dazuo", "工程师", "java开发");
        //RecordDTO record = new RecordDTO(INDEX_NAME, TYPE_NAME, JSON.toJSONString(person), "1");
        //IndexResponse response = saveRecord(record);
        //if (response.isCreated()) {
        //    System.out.println("indexResponse: " + JSON.toJSONString(response));
        //}
        /// 3.删除记录
        //DeleteResponse response = removeRecordByPrimary(INDEX_NAME, TYPE_NAME, "1");
        //if (response.isFound()) {
        //    System.out.println("response: " + JSONObject.toJSONString(response));
        //}
        /// 4.更新记录
        //Person person = new Person();
        //person.setUser("dazuo");
        //RecordDTO record = new RecordDTO(INDEX_NAME, TYPE_NAME, JSON.toJSONString(person), "1");
        //UpdateResponse response = updateRecord(record);
        //System.out.println("response: " + JSON.toJSONString(response));
        close();
    }

    /**
     * 通过ID更新记录
     * @param record {@link RecordDTO}
     */
    private static UpdateResponse updateRecord(RecordDTO record) {
        UpdateResponse response = null;
        if (client != null) {
            UpdateRequest updateRequest = new UpdateRequest();
            updateRequest.index(record.getIndex());
            updateRequest.type(record.getType());
            updateRequest.id(record.getId());
            updateRequest.doc(record.getDocument());
            try {
                response = client.update(updateRequest).get();
            } catch (Exception e) {
                logger.error("ElasticSearch更新数据异常 errMessage = {}", e.getMessage(), e);
            }
        }
        return response;
    }

    /**
     * 保存一条记录
     * @param record {@link RecordDTO}
     * @return {@link IndexResponse}
     */
    private static IndexResponse saveRecord(RecordDTO record) {
        IndexResponse response = null;
        if (client != null) {
            response = client.prepareIndex(record.getIndex(), record.getType(), record.getId())
                .setSource(record.getDocument()).get();
        }
        return response;
    }

    /**
     * 通过ID删除记录
     * @param index 索引
     * @param type 类型
     * @param id 记录ID
     * @return {@link DeleteResponse}
     */
    private static DeleteResponse removeRecordByPrimary(String index, String type, String id) {
        DeleteResponse response = null;
        if (client != null) {
            response = client.prepareDelete(index, type, id).get();
        }
        return response;
    }

    /**
     * 通过ID查询数据
     * @param index 索引
     * @param type 类型
     * @param id 记录ID
     * @return {@link GetResponse}
     */
    private static GetResponse getRecordByPrimaryKey(String index, String type, String id) {
        GetResponse response = null;
        if (client != null) {
            response = client.prepareGet(index, type, id).get();
        }
        return response;
    }

    /** 关闭ElasticSearch连接 */
    private static void close() {
        if (client != null) {
            client.close();
        }
    }
}
