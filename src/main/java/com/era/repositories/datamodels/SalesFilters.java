/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.datamodels;

import com.era.datamodels.enums.DocumentType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class SalesFilters {
 
    private int pageNumber;
    private int paginationSize;
    private boolean pagination;
    private DocumentType DocumentType_;
    private DocumentStatus DocumentStatus_;
    private String aditionalCondition;
    private boolean ringed;
    private boolean invoiced;
    private int originSale = -1;
    private String companyCode;
    private Date from;
    private Date until;
    private boolean salesPoint;
    private boolean notInCut;
    private List<DocumentType> documentsType = new ArrayList<>();
    private List<String> likes = new ArrayList<>();
    private String search;

    
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public DocumentType getDocumentType_() {
        return DocumentType_;
    }

    public void setDocumentType_(DocumentType DocumentType_) {
        this.DocumentType_ = DocumentType_;
    }

    public DocumentStatus getDocumentStatus_() {
        return DocumentStatus_;
    }

    public void setDocumentStatus_(DocumentStatus DocumentStatus_) {
        this.DocumentStatus_ = DocumentStatus_;
    }

    public String getAditionalCondition() {
        return aditionalCondition;
    }

    public void setAditionalCondition(String aditionalCondition) {
        this.aditionalCondition = aditionalCondition;
    }

    public boolean isRinged() {
        return ringed;
    }

    public void setRinged(boolean ringed) {
        this.ringed = ringed;
    }

    public boolean isInvoiced() {
        return invoiced;
    }

    public void setInvoiced(boolean invoiced) {
        this.invoiced = invoiced;
    }

    public boolean isPagination() {
        return pagination;
    }

    public void setPagination(boolean pagination) {
        this.pagination = pagination;
    }

    public int getPaginationSize() {
        return paginationSize;
    }

    public void setPaginationSize(int paginationSize) {
        this.paginationSize = paginationSize;
    }

    public int getOriginSale() {
        return originSale;
    }

    public void setOriginSale(int originSale) {
        this.originSale = originSale;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getUntil() {
        return until;
    }

    public void setUntil(Date until) {
        this.until = until;
    }

    public boolean isSalesPoint() {
        return salesPoint;
    }

    public void setSalesPoint(boolean salesPoint) {
        this.salesPoint = salesPoint;
    }

    public boolean isNotInCut() {
        return notInCut;
    }

    public void setNotInCut(boolean notInCut) {
        this.notInCut = notInCut;
    }

    public List<DocumentType> getDocumentsType() {
        return documentsType;
    }

    public void setDocumentsType(List<DocumentType> documentsType) {
        this.documentsType = documentsType;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
