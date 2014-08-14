package org.sigmah.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class FileUploadComposite_FileUploadCompositeUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.sigmah.client.FileUploadComposite>, org.sigmah.client.FileUploadComposite.FileUploadCompositeUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("Upload")
    SafeHtml html1();
     
    @Template("Pause Upload")
    SafeHtml html2();
     
    @Template("Resume Upload")
    SafeHtml html3();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html4(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.sigmah.client.FileUploadComposite owner) {


    return new Widgets(owner).get_htmlPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.sigmah.client.FileUploadComposite owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onSendButtonClick((com.google.gwt.event.dom.client.ClickEvent) event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onPauseButtonClick((com.google.gwt.event.dom.client.ClickEvent) event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onResumeButtonClick((com.google.gwt.event.dom.client.ClickEvent) event);
      }
    };

    public Widgets(final org.sigmah.client.FileUploadComposite owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.sigmah.client.FileUploadComposite_FileUploadCompositeUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.sigmah.client.FileUploadComposite_FileUploadCompositeUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.sigmah.client.FileUploadComposite_FileUploadCompositeUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.sigmah.client.FileUploadComposite_FileUploadCompositeUiBinderImpl_GenBundle) GWT.create(org.sigmah.client.FileUploadComposite_FileUploadCompositeUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.sigmah.client.FileUploadComposite_FileUploadCompositeUiBinderImpl_GenCss_style get_style() {
      return build_style();
    }
    private org.sigmah.client.FileUploadComposite_FileUploadCompositeUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      final org.sigmah.client.FileUploadComposite_FileUploadCompositeUiBinderImpl_GenCss_style style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for htmlPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_htmlPanel() {
      return build_htmlPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_htmlPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel htmlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(htmlPanel.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord0.detach();
      htmlPanel.addAndReplaceElement(get_f_AbsolutePanel1(), get_domId0Element().get());

      this.owner.htmlPanel = htmlPanel;

      return htmlPanel;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId0;
    }

    /**
     * Getter for f_AbsolutePanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.AbsolutePanel get_f_AbsolutePanel1() {
      return build_f_AbsolutePanel1();
    }
    private com.google.gwt.user.client.ui.AbsolutePanel build_f_AbsolutePanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.AbsolutePanel f_AbsolutePanel1 = (com.google.gwt.user.client.ui.AbsolutePanel) GWT.create(com.google.gwt.user.client.ui.AbsolutePanel.class);
      // Setup section.
      f_AbsolutePanel1.add(get_sendButton(), 7, 33);
      f_AbsolutePanel1.add(get_pauseButton(), 207, 33);
      f_AbsolutePanel1.add(get_resumeButton(), 307, 33);
      f_AbsolutePanel1.add(get_fileUpload(), 4, 2);
      f_AbsolutePanel1.add(get_responseHTML(), 7, 91);
      f_AbsolutePanel1.add(get_progressBox(), 125, 62);
      f_AbsolutePanel1.add(get_f_Label2(), 9, 67);
      f_AbsolutePanel1.setHeight("302px");


      return f_AbsolutePanel1;
    }

    /**
     * Getter for sendButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_sendButton() {
      return build_sendButton();
    }
    private com.google.gwt.user.client.ui.Button build_sendButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button sendButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      sendButton.setHTML(template_html1().asString());
      sendButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      this.owner.sendButton = sendButton;

      return sendButton;
    }

    /**
     * Getter for pauseButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_pauseButton() {
      return build_pauseButton();
    }
    private com.google.gwt.user.client.ui.Button build_pauseButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button pauseButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      pauseButton.setHTML(template_html2().asString());
      pauseButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      return pauseButton;
    }

    /**
     * Getter for resumeButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_resumeButton() {
      return build_resumeButton();
    }
    private com.google.gwt.user.client.ui.Button build_resumeButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button resumeButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      resumeButton.setHTML(template_html3().asString());
      resumeButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      return resumeButton;
    }

    /**
     * Getter for fileUpload called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.vectomatic.file.FileUploadExt get_fileUpload() {
      return build_fileUpload();
    }
    private org.vectomatic.file.FileUploadExt build_fileUpload() {
      // Creation section.
      final org.vectomatic.file.FileUploadExt fileUpload = (org.vectomatic.file.FileUploadExt) GWT.create(org.vectomatic.file.FileUploadExt.class);
      // Setup section.


      this.owner.fileUpload = fileUpload;

      return fileUpload;
    }

    /**
     * Getter for responseHTML called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_responseHTML() {
      return build_responseHTML();
    }
    private com.google.gwt.user.client.ui.HTML build_responseHTML() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML responseHTML = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      responseHTML.setHeight("184px");
      responseHTML.setWordWrap(true);
      responseHTML.setWidth("431px");


      this.owner.responseHTML = responseHTML;

      return responseHTML;
    }

    /**
     * Getter for progressBox called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.IntegerBox get_progressBox() {
      return build_progressBox();
    }
    private com.google.gwt.user.client.ui.IntegerBox build_progressBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.IntegerBox progressBox = (com.google.gwt.user.client.ui.IntegerBox) GWT.create(com.google.gwt.user.client.ui.IntegerBox.class);
      // Setup section.
      progressBox.setVisibleLength(3);


      this.owner.progressBox = progressBox;

      return progressBox;
    }

    /**
     * Getter for f_Label2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label2() {
      return build_f_Label2();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label2() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label2.setText("Percent Progress:");


      return f_Label2;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.


      return domId0Element;
    }
  }
}
