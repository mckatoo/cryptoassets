/**
 * @author Milton Carlos Katoo
 * @email mckatoo@gmail.com
 * @create date 2019-02-01 22:42:00
 * @modify date 2019-02-01 22:42:00
 * @desc [description]
 */

package io.ikatoo.cryptoassets.infra.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.ikatoo.cryptoassets.core.entity.UsersTypes;

/**
 * UsersRepository
 */
public interface IUsersTypesRepository extends PagingAndSortingRepository<UsersTypes, Integer> {
    List<UsersTypes> findByTypeIgnoreCaseContaining(String type);
}