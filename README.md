# Projeto-android-pdm

# CRIA NO EMPTY VIEWS ACTIVITY E NAO NO EMPTY ACTIVITY TESTA

Passos para Configuração do Projeto

    Criação do Projeto:
        Crie um novo projeto no Android Studio selecionando Empty View Activity.
        Configure o nome do projeto e a linguagem como Kotlin.

    Estrutura do Aplicativo:
        Crie uma classe Note para representar cada nota.

    Interface do Usuário (Layouts):
        Crie o layout activity_main.xml na pasta res/layout para a tela principal.
        Crie o layout activity_add_edit_note.xml na pasta res/layout para a tela de adicionar e editar notas.
        Crie o layout note_item.xml na pasta res/layout para os itens da RecyclerView.

    Configuração da MainActivity:
        Implemente a MainActivity para exibir a lista de notas utilizando RecyclerView.
        Configure o RecyclerView e um FloatingActionButton para adicionar novas notas.

    Configuração da AddEditNoteActivity:
        Implemente a AddEditNoteActivity para adicionar e editar notas.
        Configure os EditTexts e o botão Save para salvar as notas.

    Adaptador para RecyclerView:
        Crie uma classe NotesAdapter para a RecyclerView para exibir as notas.

    Salvar e Carregar Notas:
        Utilize SharedPreferences para salvar e carregar as notas localmente.

Estrutura do Projeto

    Modelo de Dados:
        Crie uma classe Note na pasta src/main/java.

    Layouts:
        res/layout/activity_main.xml
        res/layout/activity_add_edit_note.xml
        res/layout/note_item.xml

    Atividades:
        src/main/java/com/example/yourapp/MainActivity.kt
        src/main/java/com/example/yourapp/AddEditNoteActivity.kt

    Adaptador:
        src/main/java/com/example/yourapp/NotesAdapter.kt

    Salvar e Carregar Notas:
        Implemente métodos para salvar e carregar notas usando SharedPreferences na MainActivity.

Funcionalidades do Projeto

    Adicionar Notas:
        Descrição: Permite ao usuário adicionar novas notas com título e conteúdo.
        Código Relacionado: Implementado na AddEditNoteActivity e acionado pelo FAB (FloatingActionButton) na MainActivity.

    Listar Notas:
        Descrição: Exibe todas as notas salvas em uma lista na tela principal.
        Código Relacionado: Implementado na MainActivity utilizando um RecyclerView e um NotesAdapter.

    Salvar Notas Localmente:
        Descrição: As notas são salvas no armazenamento local utilizando SharedPreferences, garantindo que persistem entre sessões do aplicativo.
        Código Relacionado: Métodos para salvar e carregar notas na MainActivity.

    Editar Notas:
        Descrição: Permite ao usuário editar o título e o conteúdo de notas existentes.
        Código Relacionado: Implementado na AddEditNoteActivity, que reutiliza a lógica de adicionar notas para também editar.

    Excluir Notas:
        Descrição: Permite ao usuário excluir notas que não são mais necessárias.
        Código Relacionado: Pode ser implementado adicionando uma funcionalidade de exclusão no NotesAdapter e na MainActivity.
