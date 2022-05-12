import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockStateDefinitionProvider;
import net.minecraft.data.Main;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.TextureKey;

public class ArchExModelProvider extends FabricBlockStateDefinitionProvider {

    /*
    The end goal is to have every JSON file in ../resources/.. automatically generated.
    That includes "../resources/assets/blockstates", "../resources/assets/models/..", and "../resources/data/architecture_extensions/recipes"
    Also the code should be well-documented so it can be updated as new blocktypes are added to arch-ex over time or referenced as needed for other project.

    Thanks, woodiertexas
     */

    public static final Model ARCH_BLOCK_MODEL = ArchExModelProvider.createModel("arch_block", TextureKey.ALL);

    public ArchExModelProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void ArchExModelProvider(BlockStateModelGenerator modelGenerator) {
        ArchExModelProvider.registerArchBlock(Main.wtfToPutHere, Blocks.what?, modelGenerator)
    }

    public void generateItemModels(ItemModelGenerator modelGenerator) {
        modelGenerator.register(Main.thonk, Models.GENERATED);
        modelGenerator.register(Main.thonkAgain, Models.GENERATED);
    }
}
