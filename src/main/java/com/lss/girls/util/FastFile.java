package com.lss.girls.util;

import org.csource.common.NameValuePair;

/**
 * @author Magic
 * @date 11:07 2018/2/28
 * @description
 */
public class FastFile {
    private byte[] content;
    private String extName;
    private String groupName;
    private NameValuePair[] pairs;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public NameValuePair[] getPairs() {
        return pairs;
    }

    public void setPairs(NameValuePair[] pairs) {
        this.pairs = pairs;
    }
}
