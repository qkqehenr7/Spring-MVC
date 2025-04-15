package com.grepp.spring.infra.util.file;

public record FileDto(
    String originFilename,
    String renameFilename,
    String savePath
) {

}
