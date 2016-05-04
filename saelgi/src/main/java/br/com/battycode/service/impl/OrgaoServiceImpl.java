package br.com.battycode.service.impl;

import br.com.battycode.dao.EnderecoDAO;
import br.com.battycode.dao.OrgaoDAO;
import br.com.battycode.dto.Endereco;
import br.com.battycode.dto.Orgao;
import br.com.battycode.service.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fefedo on 26/04/16.
 */
@Service
public class OrgaoServiceImpl implements OrgaoService {

    @Autowired
    private OrgaoDAO orgaoDAO;

    @Autowired
    private EnderecoDAO enderecoDAO;

    public List<Orgao> obterOrgaos(){
        return orgaoDAO.findAllOrgao();
    }

    @Override
    public Orgao obterOrgao(Integer codigo) {
        return orgaoDAO.obterOrgao(codigo);
    }

    @Override
    public void removerOrgao(Integer codigo) {
        orgaoDAO.removerOrgao(codigo);
    }

    @Override
    public void criarEditarOrgao(Orgao orgao) {
        if (orgao.getCodigo() == null){
            orgaoDAO.criarOrgao(orgao);
            return;
        }
        orgaoDAO.editarOrgao(orgao);
    }

    @Override
    public void editarEndereco(Endereco endereco) {
        enderecoDAO.editarEndereco(endereco);
    }

    @Override
    public Endereco obterEndereco(Integer codigo) {
        return enderecoDAO.find(codigo);
    }

}
