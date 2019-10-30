package com.anatoliapark.nursinghome.model.webpage;

import com.anatoliapark.nursinghome.model.base.BaseConstantEntity;

import javax.persistence.*;

@Entity
@Table(name="webpage_component")
public class WebPageComponent extends BaseConstantEntity {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id", referencedColumnName = "id")
    private WebPage webPage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_type_id", referencedColumnName = "id")
    private WebPageComponentType componentType;

    public WebPage getWebPage() {
        return webPage;
    }

    public void setWebPage(WebPage webPage) {
        this.webPage = webPage;
    }

    public WebPageComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(WebPageComponentType componentType) {
        this.componentType = componentType;
    }
}