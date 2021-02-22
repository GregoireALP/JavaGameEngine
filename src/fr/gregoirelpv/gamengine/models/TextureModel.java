package fr.gregoirelpv.gamengine.models;

import fr.gregoirelpv.gamengine.textures.ModelTexture;

public class TextureModel {

    private RawModel rawModel;
    private ModelTexture texture;

    public TextureModel(RawModel rawModel, ModelTexture texture) {
        this.rawModel = rawModel;
        this.texture = texture;
    }

    public ModelTexture getTexture() {
        return texture;
    }

    public RawModel getRawModel() {
        return rawModel;
    }
}
