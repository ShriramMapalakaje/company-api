package org.example.companyapi.services;

import io.imagekit.sdk.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.example.companyapi.model.Document;
import org.example.companyapi.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;

import io.imagekit.sdk.models.results.Result;
import java.io.IOException;

@Slf4j
@Service
public class DocumentService {

    @Autowired
    ImageKitService imageKitService;
    @Autowired
    DocumentRepository documentRepository;

    public Document uploadDocument(MultipartFile file,
                                   String fileName,
                                   String fileType,
                                   String folderName) throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException, BadRequestException, UnknownException, IOException {
        Result result = (Result) imageKitService.uploadDocument(file, fileName, folderName);
        String docUrl = result.getUrl();
        Document document = new Document(
                fileName,
                file.getOriginalFilename(),
                fileType,
                docUrl
        );
        return documentRepository.save(document);

    }
}