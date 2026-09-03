package aula_backend.demo.service;

import aula_backend.demo.model.Equipamento;
import aula_backend.demo.repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public List<Equipamento> listarTodos() {
        return equipamentoRepository.findAll();
    }

    public Equipamento buscarPorId(Long id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
    }

    public Equipamento salvar(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento atualizar(Long id, Equipamento equipamentoAtualizado) {
        Equipamento equipamento = buscarPorId(id);
        equipamento.setTipo(equipamentoAtualizado.getTipo());
        equipamento.setMarca(equipamentoAtualizado.getMarca());
        equipamento.setModelo(equipamentoAtualizado.getModelo());
        equipamento.setNumeroSerie(equipamentoAtualizado.getNumeroSerie());
        return equipamentoRepository.save(equipamento);
    }

    public void deletar(Long id) {
        equipamentoRepository.deleteById(id);
    }
}
