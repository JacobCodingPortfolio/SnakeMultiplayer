package pl.game.common.model;

import pl.game.common.util.IdGenerator;

public class AbstractModel {

    private String modelId;

    public AbstractModel() {
        this.modelId = IdGenerator.generateObjectIdentification();
    }

    public String getModelId() {
        return modelId;
    }

    @Override
    public boolean equals(Object obj) {
        AbstractModel that = (AbstractModel) obj;
        return that.modelId.equals(this.modelId);
    }
}
