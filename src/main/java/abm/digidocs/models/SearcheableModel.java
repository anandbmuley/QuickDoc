package abm.digidocs.models;

import abm.digidocs.facade.Module;

public abstract class SearcheableModel {

    private Module module;

    public SearcheableModel(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }

    public abstract String getTitle();

}
