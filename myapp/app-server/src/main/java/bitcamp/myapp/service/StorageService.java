package bitcamp.myapp.service;

import java.io.InputStream;
import java.util.Map;

public interface StorageService {
  String CONTENT_TYPE = "contentType";

  void upload(String filePath, InputStream in, Map<String, Object> options) throws Exception;
}
