package com.profitsoftware;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.util.ArrayList;
import java.util.List;


public class MainLayout extends HorizontalLayout {
  public DocumentsLayout documentsLayout;
  public DocumentLayout documentLayout;
  public Document document = null;
  private List<Document> documents = null;

  public MainLayout() {
    setWidth("100%");

    documentsLayout = new DocumentsLayout();
    documentLayout = new DocumentLayout();

    add(documentsLayout);
  }

  public void setDocuments(List<Document> documents) {
    this.documents = documents;

    documentsLayout.grid.setItems(documents);
    documentsLayout.grid.addItemClickListener(event -> selectDocument(event.getItem()));
    documentLayout.sendButton.addClickListener(event -> sendDocument());
    documentLayout.removeButton.addClickListener(event -> confirmRemoveDocument());
    documentLayout.closeButton.addClickListener(event -> closeDocument());
  }

  private void selectDocument(Document document) {
    this.document = document;

    if (document != null) {
      add(documentLayout);

      documentLayout.preview.setValue(document.toString());

      List<Field> fields = new ArrayList<>();
      fields.add(new Field("id", document.getId()));
      fields.add(new Field("name", document.getName()));
      fields.add(new Field("code", document.getCode()));
      fields.add(new Field("personalNumber", document.getPersonalNumber()));
      fields.add(new Field("businessId", document.getBusinessId()));
      fields.add(new Field("createdTime", document.getCreatedTime() != null ? document.getCreatedTime().toString() : ""));
      fields.add(new Field("modifiedTime", document.getModifiedTime() != null ? document.getModifiedTime().toString() : ""));

      documentLayout.fieldsGrid.setItems(fields);
    }
    else
      remove(documentLayout);
  }

  private void sendDocument() {
    SendDocumentDialog dialog = new SendDocumentDialog(document);
    dialog.open();
  }

  private void confirmRemoveDocument() {
    RemoveDocumentDialog dialog = new RemoveDocumentDialog(document, event -> removeDocument());
    dialog.open();
  }

  private void removeDocument() {
    documents.remove(document);
    documentsLayout.grid.setItems(documents);

    selectDocument(null);
  }

  private void closeDocument() {
    selectDocument(null);
  }
}
